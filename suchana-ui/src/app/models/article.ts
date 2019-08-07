import {Author} from "./author";

export class Article {
  id: number;
  title: string;
  content:string;
  publishDate:string;
  noOfViews:number;
  categories: Author[];
}
