import { Component, OnInit } from '@angular/core';
import { Book } from '../Model/Book';
import { BookStoreService } from '../book-store.service';
import { NgForm } from '@angular/forms';
import { Category } from '../Model/Category';

@Component({
  selector: 'app-create-books',
  templateUrl: './create-books.component.html',
  styleUrls: ['./create-books.component.css']
})
export class CreateBooksComponent implements OnInit {
  constructor(private bookStoreService : BookStoreService) { }
  book :Book=new Book();
  message;
  errorMessage;
  category: any;

  showError:boolean;
  showMessage:boolean;

  ngOnInit() {
    this.bookStoreService.displayAllCategory().subscribe(
      data=>{this.category=data},
      error=>{this.errorMessage= error.error.message, this.showError=true}
    )

    }

  createBook(form :NgForm){
    this.bookStoreService.createBook(this.book).subscribe(
      data=>{this.message=data.message, this.showMessage=true},
      error=>{this.errorMessage=error.error.message, this.showError=true}
    );
    form.reset();
  }

}
