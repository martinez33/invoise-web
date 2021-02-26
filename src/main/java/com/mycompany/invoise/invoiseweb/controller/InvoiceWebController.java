package com.mycompany.invoise.invoiseweb.controller;

import com.mycompany.invoise.core.entity.Address;
import com.mycompany.invoise.core.entity.Customer;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import com.mycompany.invoise.invoiseweb.form.InvoiceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/invoice")
public class InvoiceWebController {

    @Autowired
    private InvoiceServiceInterface invoiceServiceInterface;

    public InvoiceServiceInterface getInvoiceServiceInterface() {
        return invoiceServiceInterface;
    }

    public void setInvoiceServiceInterface(InvoiceServiceInterface invoiceServiceInterface) {
        this.invoiceServiceInterface = invoiceServiceInterface;
    }

    @PostMapping("/create")
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult result){
        if(result.hasErrors()){
            return "invoice-create-form";
        }
        Invoice invoice = new Invoice();
        Customer customer = new Customer(invoiceForm.getCustomerName());
        invoice.setCustomer(customer);
        Address address = new Address(
                invoiceForm.getStreetName(),
                invoiceForm.getStreetNumber(),
                invoiceForm.getCity(),
                invoiceForm.getZipCode(),
                invoiceForm.getCountry()
        );
        customer.setAddress(address);
        invoice.setOrderNumber(invoiceForm.getOrderNumber());
        invoiceServiceInterface.createInvoice(invoice);
        return "invoice-created";
    }

    @GetMapping("/home")
    public String displayHome(Model model){
        System.out.println("La méthode displayHome a été invoquée");
        //model.addAttribute("invoices", invoiceServiceInterface.getInvoiceList());
        return "invoice-home";
    }

    /*@GetMapping("/{id}")
    public String displayInvoice(@PathVariable("id") String number, Model model){
        System.out.println("La méthode displayInvoice a été invoquée");
        model.addAttribute("invoice", invoiceServiceInterface.getInvoiceByNumber(number));
        return "invoice-details";
    }*/

    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm InvoiceForm){

        return "invoice-create-form";
    }
}
