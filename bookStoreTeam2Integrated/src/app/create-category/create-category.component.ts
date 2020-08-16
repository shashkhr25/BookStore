import { Component, OnInit } from '@angular/core';
import { BookStoreService } from '../book-store.service';
import { Category } from '../Model/Category';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrls: ['./create-category.component.css']
})
export class CreateCategoryComponent implements OnInit {

  constructor(private bookStoreService : BookStoreService) { }

  category : Category = new Category();
  message;
  errorMessage;

  showError:boolean;
  showMessage:boolean= true;

  ngOnInit() {
  }

  createCategory(form :NgForm){
    this.showError=false;
    this.showMessage=false;
    this.bookStoreService.createCategory(this.category).subscribe(
      data=>{this.message=data.message, this.showMessage=true, alert(this.message)},
      error=>{this.errorMessage=error.error.message, this.showError=true, console.log(error.error.message)}
    );
    form.reset();
  }


}
