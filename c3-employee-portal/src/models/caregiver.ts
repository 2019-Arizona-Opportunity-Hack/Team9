import { Person } from './person';
import { Address } from './address';

export class Caregiver {
  caregiver_id: string;
  person: Person;
  address: Address;
  marital_status: string;
  housing_type: string;
  education_level: string;
  employment_type: string;
  income_amount: number;
  income_types: string[];
  child_care_type: string;
}
