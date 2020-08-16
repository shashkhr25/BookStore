import { Component, OnInit } from '@angular/core';
import { BookStoreService } from '../book-store.service';
import { Category } from '../Model/Category';

@Component({
  selector: 'app-display-category',
  templateUrl: './display-category.component.html',
  styleUrls: ['./display-category.component.css']
})
export class DisplayCategoryComponent implements OnInit {

  constructor(private bookStoreService :BookStoreService) { }
  category: any;
  showError: boolean;
  showData:boolean;
  errorMessage: String;

  ngOnInit() {
    this.bookStoreService.displayAllCategory().subscribe(
      data=>{this.category=data, this.showData=true},
      error=>{this.errorMessage= error.error.message, this.showError=true}
    )
  }




}
