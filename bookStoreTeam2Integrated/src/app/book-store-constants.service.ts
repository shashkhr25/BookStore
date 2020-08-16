import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookStoreConstantsService {

  constructor() { }

  public static base_url = "http://localhost:8082/bookmanagementmonolithic";
  public static create_category = "/manageCategory/create";
  public static display_category = "/manageCategory/displayAllCategory";
  public static update_category = "/manageCategory/update";
  public static delete_category = "/manageCategory/delete";

  public static create_book = "/manageBook/create";
  public static display_book = "/manageBook/displayAllBook";
  public static update_book = "/manageBook/update";
  public static delete_book = "/manageBook/delete";

  public static admin_login= "/adminlogin/";


}
