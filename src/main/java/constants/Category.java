package constants;

/**
 * @date Apr 30, 2017
 * @author vsantamaria
 */

public enum Category {
	
	MOTOR("motor"),
	COCHES("coches-de-segunda-mano"),
	INMOBILIARIA("inmobiliaria"),
	VIVIENDAS("venta-de-viviendas"),
	TERRENOS1("solares"),
	TERRENOS2("parcelas"), 
	TERRENOS3("venta-de-fincas"),
	MOTOS("motos-de-segunda-mano");
	
	private final String value;
	private final String name;
	
	Category(String value) {
		this.value = value;
		this.name = name();
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
    public String toString() {
        return value;
    }
}
