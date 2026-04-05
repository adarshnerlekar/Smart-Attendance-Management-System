package com.System.Entity;

import com.System.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Techer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Techername;
	private String Email;
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Role Role;
    

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
