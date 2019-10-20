import { TestBed } from '@angular/core/testing';

import { C3ApiService } from './c3-api.service';

describe('C3ApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: C3ApiService = TestBed.get(C3ApiService);
    expect(service).toBeTruthy();
  });
});
