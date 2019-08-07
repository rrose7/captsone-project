import { Component, OnInit } from '@angular/core';
import {ArticleService} from "../../../services/article.service";
import {CategoriesService} from "../../../services/categories.service";



class Article {
}

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {

  articles: [];
  categories:[];
  article:Article;



  constructor(private articleService: ArticleService, private categoriesService: CategoriesService) { }

  ngOnInit() {
    const author = JSON.parse(localStorage.getItem('loggedInUser'));
    this.articleService.getArticles(author.id).subscribe((data) => this.articles = data);
  }

  createArticleForm() {
    this.article = new Article();

  }
  getArticles(){
    this.articleService.getArticles(this.article).subscribe(data=>{
      this.article=data
    });
  }
  submitArticleEdit() {
    this.articleService.updateArticle(this.article).subscribe(() => this.getArticles());
    this.article = null;
  }

  editArticles(article) {
    this.article = article;

  }

  cancel() {
    this.article = null;
  }
}
