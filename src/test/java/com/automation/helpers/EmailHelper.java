package com.automation.helpers;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EmailHelper {

    private Folder folder;

    public EmailHelper(String userName, String password) throws Exception {

        String host = "imap.googlemail.com";

        Session session = Session.getDefaultInstance(new Properties());

        Store store = session.getStore("imaps");

        store.connect(host, 993, userName, password);

        folder = store.getFolder("INBOX");

        folder.open(Folder.READ_WRITE);
    }

    /**
     * Gets one line of text
     * In this example, the subject of the email is 'authentication code'
     */
    public String getVerificationCode() throws Exception {

        String otp = null;
        // Fetch unseen messages from inbox folder
        Message[] messages = folder.getMessages(1,10);

        // Sort messages from recent to oldest
        Arrays.sort(messages, (m1, m2) -> {
            try {
                return m2.getSentDate().compareTo(m1.getSentDate());
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        });

        for (Message message : messages) {
            if (message.getSubject().contains("authentication code")) {

                String text = getTextFromMessage(message);

                Scanner sc = new Scanner(text);

                String line = null;
                while (sc.hasNextLine()) {
                    line = sc.nextLine().trim();
                    try {
                        otp = String.format("%06d", Integer.parseInt(line));
                        break;
                    } catch (NumberFormatException nfx) {
                        //Ignore the exception
                    }
                }
                //message.setFlag(Flags.Flag.SEEN, true);
                break;
            }
        }

        return otp;
    }

    private String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    private String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart)  throws MessagingException, IOException{
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart){
                result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
            }
        }
        return result;
    }

    //************* EMAIL ACTIONS *******************

    public void openEmail(Message message) throws Exception {
        message.getContent();
    }

    public int getNumberOfMessages() throws MessagingException {
        return folder.getMessageCount();
    }

    public int getNumberOfUnreadMessages() throws MessagingException {
        return folder.getUnreadMessageCount();
    }

    /**
     * Gets a message by its position in the folder. The earliest message is indexed at 1.
     */
    public Message getMessageByIndex(int index) throws MessagingException {
        return folder.getMessage(index);
    }

    public Message getLatestMessage() throws MessagingException {
        return getMessageByIndex(getNumberOfMessages());
    }

    /**
     * Gets all messages within the folder
     */
    public Message[] getAllMessages() throws MessagingException {
        return folder.getMessages();
    }

    /**
     * @param maxToGet maximum number of messages to get, starting from the latest. For example, enter 100 to get the last 100 messages received.
     */
    public Message[] getMessages(int maxToGet) throws MessagingException {
        Map<String, Integer> indices = getStartAndEndIndices(maxToGet);
        return folder.getMessages(indices.get("startIndex"), indices.get("endIndex"));
    }

    /**
     * Searches for messages with a specific subject
     *
     * @param subject     Subject to search messages for
     * @param unreadOnly  Indicate whether to only return matched messages that are unread
     * @param maxToSearch maximum number of messages to search, starting from the latest. For example, enter 100 to search through the last 100 messages.
     */
    public Message[] getMessagesBySubject(String subject, boolean unreadOnly, int maxToSearch) throws Exception {
        Map<String, Integer> indices = getStartAndEndIndices(maxToSearch);

        Message messages[] = folder.search(
                new SubjectTerm(subject),
                folder.getMessages(indices.get("startIndex"), indices.get("endIndex")));

        if (unreadOnly) {
            List<Message> unreadMessages = new ArrayList<Message>();
            for (Message message : messages) {
                if (isMessageUnread(message)) {
                    unreadMessages.add(message);
                }
            }
            messages = unreadMessages.toArray(new Message[]{});
        }

        return messages;
    }

    private Map<String, Integer> getStartAndEndIndices(int max) throws MessagingException {
        int endIndex = getNumberOfMessages();
        int startIndex = endIndex - max;

        //In event that maxToGet is greater than number of messages that exist
        if (startIndex < 1) {
            startIndex = 1;
        }

        Map<String, Integer> indices = new HashMap<String, Integer>();
        indices.put("startIndex", startIndex);
        indices.put("endIndex", endIndex);

        return indices;
    }

    /**
     * Returns HTML of the email's content
     */
    public String getMessageContent(Message message) throws Exception {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(message.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }

    //************* BOOLEAN METHODS *******************

    /**
     * Searches an email message for a specific string
     */
    public boolean isTextInMessage(Message message, String text) throws Exception {
        String content = getMessageContent(message);

        //Some Strings within the email have whitespace and some have break coding. Need to be the same.
        content = content.replace("&nbsp;", " ");
        return content.contains(text);
    }

    public boolean isMessageInFolder(String subject, boolean unreadOnly) throws Exception {
        int messagesFound = getMessagesBySubject(subject, unreadOnly, getNumberOfMessages()).length;
        return messagesFound > 0;
    }

    public boolean isMessageUnread(Message message) throws Exception {
        return !message.isSet(Flags.Flag.SEEN);
    }

    private Message[] getMatchedEmails(Message[] messages) throws MessagingException {

        // creates a search criterion
        SearchTerm searchCondition = new SearchTerm() {
            @Override
            public boolean match(Message message) {
                try {
                    if (message.getSubject().contains("authentication code")) {
                        return true;
                    }
                } catch (MessagingException ex) {
                    ex.printStackTrace();
                }
                return false;
            }
        };

        // performs search through the folder
        Message[] foundMessages = folder.search(searchCondition);

        return foundMessages;
    }


    /**
     *  Method to delete all message from inbox
     */
    public void clearInbox() throws Exception {
        Message[] messages = folder.getMessages();
        for (int i = 0; i < messages.length; i++) {
            Message message = messages[i];
            message.setFlag(Flags.Flag.DELETED, true);
        }
    }

    /**
     *  Waits for new mail for 20 seconds
     */
    public void waitForNewMail(int initialMailsCount) throws Exception {
        Message[] messages;
        for (int i = 1; i <= 40; i++) {
            messages = folder.getMessages();
           if(messages.length>initialMailsCount){
                break;
           }
           Thread.sleep(500);
        }
    }

    public int getMailsCount() throws Exception {
        Message[] messages = folder.getMessages();
        return messages.length;
    }
}
