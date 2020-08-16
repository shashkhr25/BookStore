import { Component, OnInit } from '@angular/core';
import { BookStoreService } from '../book-store.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-delete-category',
  templateUrl: './delete-category.component.html',
  styleUrls: ['./delete-category.component.css']
})
export class DeleteCategoryComponent implements OnInit {

  constructor(private bookStoreService : BookStoreService, private route : ActivatedRoute) { }

  categoryId;
  showModal=true;

  ngOnInit() {
  }

  openDialog()
  {
    this.showModal=true;
  }

  closeDialog()
  {
    this.showModal=false;
  }
  deleteCategory()
  {
    this.route.paramMap.subscribe(params=>{
      this.categoryId= params.get('categoryId');
      this.bookStoreService.deleteCategory(this.categoryId).subscribe(
      data=>{ alert(data.message),  this.showModal=false;},
      error=>{alert(error.error.message), this.showModal=false;},
      )
    })
  }
}
