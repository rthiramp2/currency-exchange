package com.lvadm.currency.exchange.dbo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDBO {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private Boolean enabled;
    private String authority;

}
