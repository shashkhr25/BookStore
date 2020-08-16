import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from './Model/Category';
import { BookStoreConstantsService } from './book-store-constants.service';
import { Book } from './Model/Book';

@Injectable({
  providedIn: 'root'
})
export class BookStoreService {

  constructor(private http : HttpClient) { }

  public createCategory ( category : Category ) :Observable<any>{
    return this.http.post(BookStoreConstantsService.base_url+BookStoreConstantsService.create_category, category);
  }

  public displayAllCategory():Observable<any>{
    return this.http.get(BookStoreConstantsService.base_url+BookStoreConstantsService.display_category);
  }

  public deleteCategory(categoryId):Observable<any>{ 
    return this.http.delete(BookStoreConstantsService.base_url+BookStoreConstantsService.delete_category+'/'+categoryId);
  }

  public updateCategory(category : Category):Observable<any>{
    return this.http.put(BookStoreConstantsService.base_url+ BookStoreConstantsService.update_category, category);
  }

  public updateBook(book : Book):Observable<any>{
    return this.http.post(BookStoreConstantsService.base_url+BookStoreConstantsService.update_book, book );
  }

  public displayAllBooks():Observable<any>{
    return this.http.get(BookStoreConstantsService.base_url+BookStoreConstantsService.display_book);
  }

  public deleteBook(bookId):Observable<any>{
    return this.http.delete(BookStoreConstantsService.base_url+BookStoreConstantsService.delete_book+"/"+bookId );
  }
  public createBook(book): Observable<any>{
    return this.http.post(BookStoreConstantsService.base_url+BookStoreConstantsService.create_book, book);
  }

  public loginAdmin(email:string, password:string) :Observable<any>
  {
    return this.http.get(BookStoreConstantsService.base_url+BookStoreConstantsService.admin_login+email+"/"+password);
  }
}
