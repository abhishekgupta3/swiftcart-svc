package com.swiftcart.cartservice.entities;

import com.swiftcart.cartservice.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int userId;
    String name;
    String username;
    String password;
    String role;

    public User(UserDto userDto) {
        this.userId = userDto.getId();
        this.name = userDto.getName();
        this.username = userDto.getUsername();
        this.password = userDto.getPassword();
        this.role = userDto.getRole();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
