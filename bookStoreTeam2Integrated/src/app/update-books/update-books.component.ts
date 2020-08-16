import { Component, OnInit } from '@angular/core';
import { Book } from '../Model/Book';
import { BookStoreService } from '../book-store.service';
import { ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-books',
  templateUrl: './update-books.component.html',
  styleUrls: ['./update-books.component.css']
})
export class UpdateBooksComponent implements OnInit {

  book :Book=new Book();
  message;
  errorMessage;
  todayDate : Date = new Date();
  showMessage:boolean;
  showError:boolean;

  constructor(private bookStoreService: BookStoreService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params=>{
      this.book.bookId= parseInt(params.get('bookId'));
    })
  }

  updateBook(form :NgForm){
    this.book.lastUpdateTime=this.todayDate;
    this.bookStoreService.updateBook(this.book).subscribe(
      data=>{this.message=data.message,alert(this.message), this.showMessage=true},
      error=>{this.errorMessage=error.error.message, this.errorMessage=true, console.log(error.error.message)}
    )
    form.reset();
  }

}
