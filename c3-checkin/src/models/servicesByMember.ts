import {Service} from './service';

export class ServicesByMember {
  constructor(
    public id: number,
    public service: Service[]
  ) { }
}
