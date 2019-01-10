import java.util.ArrayList;
/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store
{
    // instance variables - replace the example below with your own
    ArrayList<Customer> wrapper;

    public Store()
    {
        wrapper = new ArrayList<Customer>();
    }

    public void addCustomer(String name)
    {
        wrapper.add(new Customer(name));
    }
    
    public void addPurchase(String name, int amount)
    {
        if (wrapper.indexOf(name) == -1)
        {
            addCustomer(name);
            wrapper.get(wrapper.size() - 1).addPurchase(amount);
        }
        
        else
        {
            wrapper.get(wrapper.indexOf(name)).addPurchase(amount);
        }
    }
    
    public String toString()
    {
        String res = new String("");
        for (int i = 0; i < wrapper.size(); i++)
        {
            res += wrapper.get(i).toString();
        }
        
        return res;
    }
    
    public String bestCustomer()
    {
        String res = wrapper.get(0).getName();
        int max = wrapper.get(0).getAmount();
        for (int i = 1; i < wrapper.size(); i++)
        {
            if (max < wrapper.get(i).getAmount())
            {
                max = wrapper.get(i).getAmount();
            }
        } 
        
        return res;
    }
    
    public ArrayList<String> bestCustomer(int topN)
    {
        ArrayList<Customer> res;
        
        if (topN >= wrapper.size())
        {
            res = new ArrayList(wrapper);
        }
        
        else
        {
            res = new ArrayList<Customer>();
            for (int i = 0; i < wrapper.size(); i++)
            {
                boolean max = true;
                for (int j = res.size() - 1; j >= 0; j--)
                {
                    if (wrapper.get(i).getAmount() < res.get(j).getAmount() && j < res.size() - 1)
                    {
                        max = false;
                        res.remove(res.size() - 1);
                        res.add(j + 1, wrapper.get(i));
                        break;
                    }
                }    
                
                if (max)
                {
                    res.remove(res.size() - 1);
                    res.add(0, wrapper.get(i));
                }
            }   
        }
        
        ArrayList<String> ret = new ArrayList<String>();
        for (int i = 0; i < res.size(); i++)
        {
            ret.add(res.get(i).getName());
        }
        
        return ret;
    }
}
