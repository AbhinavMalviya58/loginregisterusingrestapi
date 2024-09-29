package com.example.loginregisterusingrestapi.backend;

public class LoginResponse {
    private boolean success;
    private String message;
    private String token;
    private User user;
    private AccountPreference accountPreference;
    private NotificationSettings notificationSettings;
    private boolean isVerified;

    // Getters and setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccountPreference getAccountPreference() {
        return accountPreference;
    }

    public void setAccountPreference(AccountPreference accountPreference) {
        this.accountPreference = accountPreference;
    }

    public NotificationSettings getNotificationSettings() {
        return notificationSettings;
    }

    public void setNotificationSettings(NotificationSettings notificationSettings) {
        this.notificationSettings = notificationSettings;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    // Inner classes
    public static class User {
        private String id;
        private String avatar;
        private String fullName;
        private String email;
        private String deviceToken;
        private String type;
        private String socialId;

        // Getters and setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDeviceToken() {
            return deviceToken;
        }

        public void setDeviceToken(String deviceToken) {
            this.deviceToken = deviceToken;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSocialId() {
            return socialId;
        }

        public void setSocialId(String socialId) {
            this.socialId = socialId;
        }
    }

    public static class AccountPreference {
        private String locale;
        private String timeZone;
        private String currency;

        // Getters and setters
        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public String getTimeZone() {
            return timeZone;
        }

        public void setTimeZone(String timeZone) {
            this.timeZone = timeZone;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    public static class NotificationSettings {
        private boolean itemSold;
        private boolean bidActivity;
        private boolean priceChange;
        private boolean auctionExpiration;
        private boolean outBid;
        private boolean referralSuccessful;
        private boolean ownedAssetUpdates;
        private boolean successfulPurchase;

        // Getters and setters
        public boolean isItemSold() {
            return itemSold;
        }

        public void setItemSold(boolean itemSold) {
            this.itemSold = itemSold;
        }

        public boolean isBidActivity() {
            return bidActivity;
        }

        public void setBidActivity(boolean bidActivity) {
            this.bidActivity = bidActivity;
        }

        public boolean isPriceChange() {
            return priceChange;
        }

        public void setPriceChange(boolean priceChange) {
            this.priceChange = priceChange;
        }

        public boolean isAuctionExpiration() {
            return auctionExpiration;
        }

        public void setAuctionExpiration(boolean auctionExpiration) {
            this.auctionExpiration = auctionExpiration;
        }

        public boolean isOutBid() {
            return outBid;
        }

        public void setOutBid(boolean outBid) {
            this.outBid = outBid;
        }

        public boolean isReferralSuccessful() {
            return referralSuccessful;
        }

        public void setReferralSuccessful(boolean referralSuccessful) {
            this.referralSuccessful = referralSuccessful;
        }

        public boolean isOwnedAssetUpdates() {
            return ownedAssetUpdates;
        }

        public void setOwnedAssetUpdates(boolean ownedAssetUpdates) {
            this.ownedAssetUpdates = ownedAssetUpdates;
        }

        public boolean isSuccessfulPurchase() {
            return successfulPurchase;
        }

        public void setSuccessfulPurchase(boolean successfulPurchase) {
            this.successfulPurchase = successfulPurchase;
        }
    }
}

