import { Airport } from "./Airport";

export class Schedule {
    scheduleId: number=0;
    airrivalTime: string='';
    departureTime: string='';

    sourceAirport: Airport = new Airport();
    destinationAirport: Airport = new Airport();
}