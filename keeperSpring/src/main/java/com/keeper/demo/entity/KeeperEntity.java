package com.keeper.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "keeper_names")
public class KeeperEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	//private String title;
	//private String content;
	
	public KeeperEntity() {
    }
	
	public KeeperEntity(String name) {
		super();
		this.name=name;
	}
	
	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		return "KeeperEntity [id="+ id +", name="+ name + "]";
	}

}
