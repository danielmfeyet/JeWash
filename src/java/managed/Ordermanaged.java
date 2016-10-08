/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managed;

import Entity.Address;
import Entity.Article;
import Entity.Customer;
import Entity.MD5;
import Entity.Salesorder;
import SessionBean.AddressFacade;
import SessionBean.ArticleFacade;
import SessionBean.CustomerFacade;
import SessionBean.SalesorderFacade;
import java.io.IOException;
import java.io.Serializable;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MFEYET Daniel Steven
 */
@ManagedBean
@SessionScoped
public class Ordermanaged implements Serializable {
    @EJB
    private ArticleFacade articleFacade;
    @EJB
    private CustomerFacade customerFacade;

    /**
     * Creates a new instance of Test
     */
    public Ordermanaged() {
        this.ad = new Address();
        HttpSession hs = Util.getSession();
        login = (Customer) hs.getAttribute("customer");
    }
 
    @EJB
    private SalesorderFacade order1Facade;
    @EJB
    private AddressFacade addressFacade;

    private final Customer login;

    public SalesorderFacade getSalesorderFacade() {
        return order1Facade;
    }

    public void setSalesorderFacade(SalesorderFacade order1Facade) {
        this.order1Facade = order1Facade;
    }

    public List<Salesorder> getListofOrder() {
        return ListofOrder;
    }

    public void setListofOrder(List<Salesorder> ListofOrder) {
        this.ListofOrder = ListofOrder;
    }

    private Salesorder order;

    public Salesorder getOrder() {
        return order;
    }

    public void setOrder(Salesorder order) {
        this.order = order;
    }

    public Customer getLogin() {
        return login;
    }
    private Address ad;

    public AddressFacade getAddressFacade() {
        return addressFacade;
    }

    public void setAddressFacade(AddressFacade addressFacade) {
        this.addressFacade = addressFacade;
    }

    public Address getAd() {
        return ad;
    }

    public void setAd(Address ad) {
        this.ad = ad;
    }

    public List<Address> ListofAddress;

    public List<Address> getListofAddress() {
        return addressFacade.getAllAddressbyCustomer(login);
    }

    @PostConstruct
    public void initialize() {
        this.order = new Salesorder();
        ListofAddress = new ArrayList();
        ListofAddress = addressFacade.getAllAddressbyCustomer(login);
        listofArticle=articleFacade.findAll();
        listdate.add(new Date());
        Date d = new Date();
        for (int i = 1; i <= 6; i++) {
            d.setDate(d.getDate() + i);
            listdate.add(d);
            d = new Date();

        }

        Format formatter = new SimpleDateFormat("EEEE dd MMM yyyy");
        for (int i = 0; i < listdate.size(); i++) {
            listdatestring.add(formatter.format(listdate.get(i)));
        }
        Date d1 = new Date();
        d1.setDate(d.getDate() + 2);
        listdate1.add(d1);

        for (int i = 3; i <= 8; i++) {
            d1 = new Date();
            d1.setDate(d.getDate() + i);
            listdate1.add(d1);

        }

        for (int i = 0; i < listdate1.size(); i++) {
            listdatestring1.add(formatter.format(listdate1.get(i)));
        }
        if (new Date().getHours() < 16) {
            ldaterecup.add("18H:30-19H:00");
            ldaterecup.add("19H:00-19H:30");
            ldaterecup.add("19H:30-20H:00");
            ldaterecup.add("20H:00-20H:30");
        }
        ldateliv.add("18H:30-19H:00");
        ldateliv.add("19H:00-19H:30");
        ldateliv.add("19H:30-20H:00");
        ldateliv.add("20H:00-20H:30");

    }

    /**
     * Creates a new instance of gestorder
     */
   

    public String formatDate(Date date, String pattern) {

        if (date == null) {
            return null;
        }
        if (pattern == null) {
            throw new NullPointerException("pattern");
        }

        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        return new SimpleDateFormat(pattern, locale).format(date);

    }

    public void saveAddress() {

        ad.setCustomerid(login);
        ad.setAddressactif(Boolean.TRUE);
        addressFacade.create(ad);
        ListofAddress = addressFacade.getAllAddressbyCustomer(login);
        this.ad = new Address();
    }
 public void nullAddress() {

       
        this.ad = new Address();
    }

    public void updateProfile() {

    }

    public SalesorderFacade getOrder1Facade() {
        return order1Facade;
    }

    

    public void showAddress(String p, String s, String r, String t, Integer id) {
        this.ad.setAddressname(p);
        this.ad.setAddresscity(s);
        this.ad.setAddressneighborhood(r);
        this.ad.setAddressdetail(t);
        this.ad.setAddressid(id);
        this.ad.setCustomerid(login);
    }

    public void editAddress() {
        Address d = addressFacade.getAddressbyId(ad.getAddressid());
        d.setAddresscity(ad.getAddresscity());
        d.setAddressdetail(ad.getAddressdetail());
        d.setAddressname(ad.getAddressname());
        d.setAddressneighborhood(ad.getAddressneighborhood());
        addressFacade.edit(d);
        this.ad = new Address();
        ListofAddress = addressFacade.getAllAddressbyCustomer(login);
        this.ad = new Address();

    }

    public void deleteAddress() {
        Address d = addressFacade.getAddressbyId(ad.getAddressid());
        d.setAddresscity(ad.getAddresscity());
        d.setAddressdetail(ad.getAddressdetail());
        d.setAddressname(ad.getAddressname());
        d.setAddressneighborhood(ad.getAddressneighborhood());
        d.setAddressactif(Boolean.FALSE);
        addressFacade.edit(d);
        this.ad = new Address();
        ListofAddress = addressFacade.getAllAddressbyCustomer(login);
        this.ad = new Address();

    }

    private List<Salesorder> ListofOrder;

    public Converter dateConverter = new Converter() {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            Date d = null;
            SimpleDateFormat formater = new SimpleDateFormat("EEE-dd-MMM-yyyy");

            try {
                d = formater.parse(value);
            } catch (ParseException ex) {
                Logger.getLogger(gestorder.class.getName()).log(Level.SEVERE, null, ex);
            }
            return d;
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {

            Date d = (Date) value;
            return d.toString();
        }

    };

    public Converter getDateConverter() {
        return dateConverter;
    }

    public Converter addressConverter = new Converter() {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {

            String id = value;
            Integer i = Integer.parseInt(id);
            Address p = addressFacade.getAddressbyId(i);
            return p;
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {

            Address a = (Address) value;
            Integer idS = a.getAddressid();
            String ids = String.valueOf(idS);
            return ids;
        }

    };

    public Converter getAddressConverter() {
        return addressConverter;
    }

    List<Date> listdate = new ArrayList<Date>();
    List<String> listdatestring = new ArrayList<String>();
    String newdate = "";
    Date dateplanification;
    List<Date> listdate1 = new ArrayList<Date>();
    List<String> listdatestring1 = new ArrayList<String>();
    String newdate1 = "";
    Date dateplanification1;
    List<String> ldaterecup = new ArrayList<String>();
    String daterecup = "";
    List<String> ldateliv = new ArrayList<String>();
    String dateliv = "";

    public List<String> getLdateliv() {
        return ldateliv;
    }

    public void setLdateliv(List<String> ldateliv) {
        this.ldateliv = ldateliv;
    }

    public String getDateliv() {
        return dateliv;
    }

    public void setDateliv(String dateliv) {
        this.dateliv = dateliv;
    }

    public List<String> getLdaterecup() {
        return ldaterecup;
    }

    public void setLdaterecup(List<String> ldaterecup) {
        this.ldaterecup = ldaterecup;
    }

    public String getDaterecup() {
        return daterecup;
    }

    public void setDaterecup(String daterecup) {
        this.daterecup = daterecup;
    }

    public List<Date> getListdate1() {
        return listdate1;
    }

    public void setListdate1(List<Date> listdate1) {
        this.listdate1 = listdate1;
    }

    public List<String> getListdatestring1() {
        return listdatestring1;
    }

    public void setListdatestring1(List<String> listdatestring1) {
        this.listdatestring1 = listdatestring1;
    }

    public String getNewdate1() {
        return newdate1;
    }

    public void setNewdate1(String newdate1) {
        this.newdate1 = newdate1;
    }

    public Date getDateplanification1() {
        return dateplanification1;
    }

    public void setDateplanification1(Date dateplanification1) {
        this.dateplanification1 = dateplanification1;
    }

    public List<Date> getListdate() {
        return listdate;
    }

    public void setListdate(List<Date> listdate) {
        this.listdate = listdate;
    }

    public List<String> getListdatestring() {
        return listdatestring;
    }

    public void setListdatestring(List<String> listdatestring) {
        this.listdatestring = listdatestring;
    }

    public String getNewdate() {
        return newdate;
    }

    public void setNewdate(String newdate) {
        this.newdate = newdate;
    }

    public Date getDateplanification() {
        return dateplanification;
    }

    public void setDateplanification(Date dateplanification) {
        this.dateplanification = dateplanification;
    }

    public void onDateChange() throws ParseException {

        if (newdate != null) {
            Date f = new SimpleDateFormat("EEEE dd MMM yyyy").parse(newdate);
            listdate1 = new ArrayList();
            Date g = new Date();
            g.setDate(f.getDate() + 2);
            listdate1.add(g);
            for (int i = 3; i <= 8; i++) {
                g = new Date();
                g.setDate(f.getDate() + i);
                listdate1.add(g);

            }
            Format formatter = new SimpleDateFormat("EEEE dd MMM yyyy");
            listdatestring1 = new ArrayList();
            for (int i = 0; i < listdate1.size(); i++) {
                listdatestring1.add(formatter.format(listdate1.get(i)));
            }
          

        }
    }
    
         
     public void onDateChange1() throws ParseException  {
                ldaterecup.clear();
        dateplanification= new SimpleDateFormat("EEEE dd MMM yyyy", Locale.getDefault()).parse(newdate);
            if (new Date().getHours() < 16) {
            ldaterecup.add("18H:30-19H:00");
            ldaterecup.add("19H:00-19H:30");
            ldaterecup.add("19H:30-20H:00");
            ldaterecup.add("20H:00-20H:30");
        } 
            if(new Date().getDate()!=dateplanification.getDate() && new Date().getMonth() == dateplanification.getMonth()){
                ldaterecup.add("18H:30-19H:00");
            ldaterecup.add("19H:00-19H:30");
            ldaterecup.add("19H:30-20H:00");
            ldaterecup.add("20H:00-20H:30");
            }
            
     }
public String saveOrder(String datedate) throws ParseException  
    {dateplanification= new SimpleDateFormat("EEEE dd MMM yyyy", Locale.getDefault()).parse(newdate);
    dateplanification1= new SimpleDateFormat("EEEE dd MMM yyyy", Locale.getDefault()).parse(newdate1);
    
     order.setCustomerid(login);
        order.setDeliveryhour(dateliv);
        order.setCollecthour(daterecup);
        order.setOrderdatecollect(dateplanification);
        order.setOrderdatedelivery(dateplanification1);
        order1Facade.create(order);
        return "Order.xhtml?faces-redirect=true";
    }
public void logout() throws IOException {
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.invalidateSession();
    ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
}

      public void updateprofil(){
          customerFacade.edit(login);
      }
      private List<Article> listofArticle=new ArrayList() ;

    public List<Article> getListofArticle() {
        return listofArticle;
    }
    String pdw;

    public String getPdw() {
        return pdw;
    }

    public void setPdw(String pdw) {
        this.pdw = pdw;
    }
    String pdw1;

    public String getPdw1() {
        return pdw1;
    }

    public void setPdw1(String pdw1) {
        this.pdw1 = pdw1;
    }
     public String  changePassword(){
        String pageCon;
         if(login.getCustomerpassword().equals( MD5.crypt(pdw))){
             login.setCustomerpassword(pdw1);
             customerFacade.edit(login);
             FacesMessage fm = new FacesMessage("Mot de passe changé,");
              fm.setSeverity(FacesMessage.SEVERITY_INFO);
              FacesContext.getCurrentInstance().addMessage(null, fm);
                pageCon="Profile.xhtml";
         }else{
          FacesMessage fm = new FacesMessage("Le mot de passe que vous voulez changer est incorrecte,");
              fm.setSeverity(FacesMessage.SEVERITY_ERROR);
              FacesContext.getCurrentInstance().addMessage(null, fm);
                pageCon="Profile.xhtml";}
                return pageCon;
     } 
      
}
 