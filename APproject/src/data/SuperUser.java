package data;

import java.util.Iterator;

public class SuperUser extends SuperSuper {
	
	/**
	 * Login credentials of the SUper user
	 */
	private String LoginID,Password;
	
	public SuperUser(String id,String pass)
	{
		super();
		this.LoginID=id;
		this.Password=pass;
	}
	
	
	
	//GETTERS AND SETTERS
	public String getid()
	{
		return this.LoginID;
	}
	
	public String getpass()
	{
		return this.Password;
	}
	
	//other functions
	/**
	 * @param wadmin String name of the warehouse admin
	 * @param name name of the warehouse
	 * @param ID  id
	 * @return boolean
	 */
	public boolean CreateWarehouse(String wadmin,String name,String ID)
	{
		WarehouseAdministrator A=null;
		for (int i = 0; i < UserData.Wareadmin.size(); i++) {
			if(UserData.Wareadmin.get(i).getid().equals(wadmin))
			{
				A=UserData.Wareadmin.get(i);
				break;
			}
			
		}
		if(A==null)
			return false;
		Warehouse W=new Warehouse(name,ID);
		W.setAdmin(A);
		SuperSuper.Wares.add(W);
		Warehouse.Wares.add(W);
		Warehouse.Waress.add(W.getname());
		A.setWare(W);	
		A.setAdmin(A);
		return true;
	}
	
	

	public boolean CreateStore(String b,String id,String ware,String n,int m) {
		StoreAdministrator A=null;
		for(int i=0;i<UserData.Storeadmin.size();i++)
		{
			if(UserData.Storeadmin.get(i).getloginid().equals(b))
				A=UserData.Storeadmin.get(i);
		}
		if(A==null)
			return false;
		Warehouse w=null;
		for (int i = 0; i < SuperSuper.Wares.size(); i++) {
			if(SuperSuper.Wares.get(i).getID().equals(ware))
			{
				w=SuperSuper.Wares.get(i);
				break;
			}
			
		}
		if(w==null)
			return false;
		Store S=new Store(id, n, w, m);
		A.setAdmin(A);
		A.setStore(S);
		Stores.add(S);
		S.setAdmin(A);
		Store.Stores.add(S);
		Store.Storess.add(S.getname());
		return true;
		
	}
	
	public Store ViewStore(String store) {
		for(int i=0;i<Store.Storess.size();i++)
		{
			if(store.equals(Store.Stores.get(i).getname()))
				return Store.Stores.get(i);
		}
		return null;
		
	}
	
	public Warehouse ViewWarehouse(String ware)
	{
		for(int i=0;i<Warehouse.Wares.size();i++)
		{
			if(ware.equals(Warehouse.Wares.get(i).getname()))
				return Warehouse.Wares.get(i);
		}
		return null;
	}
	
	public void LinkStoW(String s,String w)
	{
		Store st=null;
		for(int i=0;i<Store.Storess.size();i++)
		{
			if(s.equals(Store.Stores.get(i).getname()))
				st=Store.Stores.get(i);
		}
		Warehouse wa=null;
		for(int i=0;i<Warehouse.Wares.size();i++)
		{
			if(w.equals(Warehouse.Wares.get(i).getname()))
				wa=Warehouse.Wares.get(i);
		}
		if(wa!=null && st!=null)
			st.setWarehouse(wa);
			
	}
	
	public boolean CreateWarehouseadmin(String lid,String pass) {
		for(int i=0;i<UserData.Wareadmin.size();i++)
		{
			
			if(UserData.Wareadmin.get(i).getid().equals(lid))
				return false;
		}
		WarehouseAdministrator W=new WarehouseAdministrator(null, null, lid, pass);
		UserData.Wareadmin.add(W);
		
		return true;
		
	}
	
	
	
	/**
	 * @param lid String login id of the Strore admin
	 * @param pass  password
	 * @return boolean
	 */
	public boolean CreateStoreAdmin(String lid,String pass)
	{
		
		for(int i=0;i<UserData.Storeadmin.size();i++)
		{
			if(UserData.Storeadmin.get(i).getloginid().equals(lid))
				return false;
		}

		StoreAdministrator s=new StoreAdministrator(lid, pass);
		UserData.Storeadmin.add(s);
		return true;
	}
	
}
