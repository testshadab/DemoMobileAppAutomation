package com.automation.mobile.models;

import java.util.List;

public class ApiResponse {

    public class StoreInformation {
        List<Store> stores;

        public List<Store> getStores() {
            return stores;
        }

        public class Store {
            public String storeId;
            public String storePreference;
            public String banner;
            public Address address;
            public class Address {
                public String address1;
                public String zipCode;
                public String city;
                public String state;
            }
        }

    }

    public class StoreSolver {
        Store ecom;

        public Store getStore() {
            return ecom;
        }

        public class Store {
            public String storeId;
            public String banner;
            public Address address;
            public boolean isDeliveryStore;
            public boolean isHybridStore;
            public boolean isPickupStore;

            public class Address {
                public String line1;
                public String zipCode;
                public String city;
                public String state;
            }
        }

    }

    public class AllOffers {
        public List<Offer> getCc() {
            return cc;
        }
        public List<Offer> getPd() {
            return pd;
        }
        List<Offer> cc;
        List<Offer> pd;

        public class Offer {
            public String offerId;
            public String offerPrice;
            public String description;
            public String status;
            public String startDate;
            public String endDate;
            public String brand;
            public String purchaseRank;
            public Hierarchies hierarchies;
            public class Hierarchies
            {
                List<String> categories;
                List<String> events;
            }

        }

    }

    public class AllEmails {
        public Sender sender;
        public String subject;
        public boolean isRead;
        public String emailId;
        public long timestamp;

        public class Sender {
            public String address;
            public String name;
        }

    }

    public class MyList {

        public List<ShoppingList> getShoppingList() {
            return shoppingList;
        }

        List<ShoppingList> shoppingList;

        public class ShoppingList {
            public boolean checked;
            public String itemType;
            public String description;
            public String title;
            public Detail detail;
            public String offerId;
            public String addedDate;
            public String categoryName;
            public class Detail
            {
                String generalDisclaimer;
                String offerPrice;
            }

        }

    }
}
