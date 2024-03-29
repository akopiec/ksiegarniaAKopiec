package pl.umcs.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
    @Entity
    @Table(name = "users")
    public class User {
        @Id
        private String username;
        @Column(nullable = false)
        private String password;
        @Column(nullable = false)
        private boolean enabled;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
        private List<Authority> authorities;
        @OneToMany(cascade=CascadeType.REMOVE)
        private List<Order> orders;
        public User() {
            enabled = true;
            authorities = new ArrayList<>();
            orders=new ArrayList<>();
        }
        public User(String username) {
            this();
            this.username = username;
        }
        public User(String username, String password) {

            this(username);

            this.password = password;
        }

        public String getUsername() {

            return username;
        }
        public void setUsername(String username) {

            this.username = username;
        }
        public String getPassword() {

            return password;
        }
        public void setPassword(String password) {

            this.password = password;
        }

        public Boolean getEnabled() {

            return enabled;
        }
        public void setEnabled(Boolean enabled) {

            this.enabled = enabled;
        }
        public List<Authority> getAuthorities() {

            return authorities;
        }
        public void setAuthorities(List<Authority> authorities) {

            this.authorities = authorities;
        }
        public List<Order> getOrders() {

            return orders;
        }
        public void setOrders(List<Order> orders) {

            this.orders = orders;
        }
    }


