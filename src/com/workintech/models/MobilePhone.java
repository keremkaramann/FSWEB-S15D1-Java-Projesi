package com.workintech.models;

import java.util.ArrayList;

public class MobilePhone {

    private String myPhone;
    private ArrayList<Contacts> contacts;

    public MobilePhone(String myPhone) {
        this.myPhone = myPhone;
        this.contacts = new ArrayList<>();
    }

    public boolean addNewContact(Contacts contacts) {
        
        if (findContact(contacts.getName()) >= 0) {
            return false;
        }
        this.contacts.add(contacts);
        return true;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact) {
        int oldContactIndex = findContact(oldContact.getName());
        if (oldContactIndex < 0) {
            return false;
        }
        this.contacts.set(oldContactIndex, newContact);
        return true;
    }

    public boolean removeContact(Contacts contact) {
        if (findContact(contact.getName()) < 0) {
            return false;
        }
        this.contacts.remove(contact);
        return true;
    }

    public int findContact(Contacts contact) {
        return this.contacts.indexOf(contact);
    }

    public Contacts queryContact(String contactName) {
        int index = findContact(contactName);
        if (index >= 0) {
            return this.contacts.get(index);
        }
        return null;
    }

    public int findContact(String contactName) {
        for (int i = 0; i < this.contacts.size(); i++) {
            Contacts contacts = this.contacts.get(i);
            if (contacts.getName().equalsIgnoreCase(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public void printContact() {
        for (int i = 0; i < this.contacts.size(); i++) {
            Contacts contact = this.contacts.get(i);
            System.out.println(i + 1 + " -   " + contact.getName() + " -> " + contact.getPhoneNum());
        }
    }
}
