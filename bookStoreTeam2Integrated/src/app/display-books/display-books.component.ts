import { Component, OnInit } from '@angular/core';
import { BookStoreService } from '../book-store.service';

@Component({
  selector: 'app-display-books',
  templateUrl: './display-books.component.html',
  styleUrls: ['./display-books.component.css']
})
export class DisplayBooksComponent implements OnInit {

  books: any;
  errorMessage:String;

  constructor(private bookStoreService : BookStoreService) { }

  ngOnInit() {
    this.bookStoreService.displayAllBooks().subscribe(
      data=>{this.books=data},
      error=>{this.errorMessage= error.error.message}
    )
  }

}
