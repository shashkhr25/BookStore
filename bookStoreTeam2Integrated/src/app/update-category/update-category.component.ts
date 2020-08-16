import { Component, OnInit } from '@angular/core';
import { Book } from '../Model/Book';
import { BookStoreService } from '../book-store.service';
import { Category } from '../Model/Category';
import { ActivatedRoute } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-category',
  templateUrl: './update-category.component.html',
  styleUrls: ['./update-category.component.css']
})
export class UpdateCategoryComponent implements OnInit {

  category : Category= new Category();
  successMessage;
  errorMessage;
  showSuccessMessage:boolean;
  showErorrMessage:boolean;

  ngOnInit() {
    this.route.paramMap.subscribe(params=>{
      this.category.categoryId= parseInt(params.get('categoryId'));
    })
  }

  constructor(private bookStoreService: BookStoreService, private route: ActivatedRoute){}

  updateCategory(form : NgForm){
    this.bookStoreService.updateCategory(this.category).subscribe(
      data=>{this.successMessage=data.message, this.showSuccessMessage=true},
      error=>{this.showErorrMessage=error.error.message, this.showErorrMessage=true}
    )
      form.reset()
  }

 
  }  
  



