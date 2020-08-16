import { Category } from "./Category";

  export class Book{
    bookId:number;
    title:string;
    author:string;
    price:number;
    description:string;
    isbnNumber:string;
    publishDate:Date;
    lastUpdateTime:Date;
    categoryId: number;
  }