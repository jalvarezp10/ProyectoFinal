import { TestBed } from '@angular/core/testing';

import { FestivalesService } from './festivales.service';

describe('FestivalesService', () => {
  let service: FestivalesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FestivalesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
