import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes} from '@angular/router';
import { DisplayCategoryComponent } from '../display-category/display-category.component';
import { DeleteCategoryComponent } from '../delete-category/delete-category.component';
import { UpdateCategoryComponent } from '../update-category/update-category.component';
import { CreateCategoryComponent } from '../create-category/create-category.component';
import { UpdateBooksComponent } from '../update-books/update-books.component';
import { DisplayBooksComponent } from '../display-books/display-books.component';
import { DeleteBookComponent } from '../delete-book/delete-book.component';
import { CreateBooksComponent } from '../create-books/create-books.component';
import { LoginAdminComponent } from '../login-admin/login-admin.component';
import { AppComponent } from '../app.component';
import { GuardService } from '../guard.service';
import { ErrorComponent } from '../error/error.component';

const appRoutes:Routes=[
  {path:'login', component: LoginAdminComponent},
  {path:'', component: LoginAdminComponent},
  {path:'error', component: ErrorComponent},
  {path:'displayCategory',component: DisplayCategoryComponent, canActivate:[GuardService]},
  {path:'createCategory', component:CreateCategoryComponent, canActivate:[GuardService]},
  {path:"deleteCategory/:categoryId", component: DeleteCategoryComponent, canActivate:[GuardService]},
  {path:"updateCategory/:categoryId", component: UpdateCategoryComponent, canActivate:[GuardService]},
  {path:"updateBook/:bookId", component: UpdateBooksComponent, canActivate:[GuardService]},
  {path:"displayBooks", component:DisplayBooksComponent, canActivate:[GuardService]},
  {path:"deleteBook/:bookId", component:DeleteBookComponent, canActivate:[GuardService]},
  {path:'createBook', component: CreateBooksComponent, canActivate:[GuardService]},
  ]


@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
