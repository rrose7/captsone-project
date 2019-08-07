import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Article} from "../../../models/article";
import {categories} from "../../../models/categories.model";


@Component({
  selector: 'app-edit-article',
  templateUrl: './edit-article.component.html',
  styleUrls: ['./edit-article.component.css']
})
export class EditArticleComponent implements OnInit {

  @Input('article') article: Article;

  @Input('categories') categories: categories[];

  @Output() updateArticle = new EventEmitter();
  @Output() cancelEvent = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
  }

  submit() {
    this.updateArticle.next();
  }

  cancel() {
    this.cancelEvent.next();
  }
}
