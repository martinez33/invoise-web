package com.mycompany.invoise.invoiseweb.api;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceServiceInterface invoiceServiceInterface;

    public InvoiceServiceInterface getInvoiceServiceInterface() {
        return invoiceServiceInterface;
    }

    public void setInvoiceServiceInterface(InvoiceServiceInterface invoiceServiceInterface) {
        this.invoiceServiceInterface = invoiceServiceInterface;
    }

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice){
        return invoiceServiceInterface.createInvoice(invoice);
    }

    @GetMapping
    public Iterable<Invoice> list(){
        System.out.println("La méthode list a été invoquée");
        return invoiceServiceInterface.getInvoiceList();
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number){
        System.out.println("La méthode displayInvoice a été invoquée");
        return invoiceServiceInterface.getInvoiceByNumber(number);
    }

    /*@GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm InvoiceForm){
        return "invoice-create-form";
    }*/
}
