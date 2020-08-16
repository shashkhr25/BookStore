import { Component, OnInit } from '@angular/core';
import { BookStoreService } from '../book-store.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-delete-book',
  templateUrl: './delete-book.component.html',
  styleUrls: ['./delete-book.component.css']
})
export class DeleteBookComponent implements OnInit {

  bookId;
  message;
  errorMessage;

  showError:boolean;
  showMessage:boolean;
  constructor(private bookStoreService: BookStoreService, private route: ActivatedRoute) { }

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

  deleteBook()
  {
    this.route.paramMap.subscribe(params=>{
      this.bookId= params.get('bookId');
      this.bookStoreService.deleteBook(this.bookId).subscribe(
      data=>{ alert(data.message),  this.showModal=false;},
      error=>{alert(error.error.message), this.showModal=false;},
      )
    })
  }

}
