import {Service} from './service';

export class ServicesByMember {
  constructor(
    public id: string,
    public service: Service[]
  ) { }
}
