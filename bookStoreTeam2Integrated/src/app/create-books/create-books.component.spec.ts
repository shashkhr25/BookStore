import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBooksComponent } from './create-books.component';

describe('CreateBooksComponent', () => {
  let component: CreateBooksComponent;
  let fixture: ComponentFixture<CreateBooksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateBooksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateBooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
