import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Author} from "../../../../models/author";
import {categories} from "../../../../models/categories.model";

@Component({
  selector: 'app-add-author',
  templateUrl: './add-author.component.html',
  styleUrls: ['./add-author.component.css']
})
export class AddAuthorComponent implements OnInit {

  @Input('author') author: Author;

  @Input('categories') categories: categories[];

  @Output() addAuthor = new EventEmitter();
  @Output() cancelEvent = new EventEmitter();

  dropdownSettings = {};

  constructor() {
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'id',
      textField: 'name',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true,
      ngModelOptions: {
        standalone: true
      }
    };
  }

  ngOnInit() {
  }

  submit() {
    this.addAuthor.next();
  }

  cancel() {
    this.cancelEvent.next();
  }

}

