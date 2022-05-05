package com.resurrected.enums;

public enum Rol {
	
	ADMIN("Administrador"), 
    CLIENT("Cliente"),
	SELLER("Vendedor"),
	SUPPLIER("Proveedor");
	
	private final String displayValue;
	
	private Rol(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
