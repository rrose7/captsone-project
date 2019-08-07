import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorssComponent } from './authorss.component';

describe('AuthorssComponent', () => {
  let component: AuthorssComponent;
  let fixture: ComponentFixture<AuthorssComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorssComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorssComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
