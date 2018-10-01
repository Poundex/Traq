import { TestBed } from '@angular/core/testing';

import { TagDataService } from './tag-data.service';

describe('TagDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TagDataService = TestBed.get(TagDataService);
    expect(service).toBeTruthy();
  });
});
