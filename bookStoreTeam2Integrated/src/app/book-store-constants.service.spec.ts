import { TestBed } from '@angular/core/testing';

import { BookStoreConstantsService } from './book-store-constants.service';

describe('BookStoreConstantsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BookStoreConstantsService = TestBed.get(BookStoreConstantsService);
    expect(service).toBeTruthy();
  });
});
