import {Entity, PrimaryGeneratedColumn, Column, ManyToOne, JoinColumn} from "typeorm";
import { Group } from "./Group";

@Entity({name: "users"})
export class User {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    name : string;

    @Column()
    age: number;

    @Column({name: "original_weight"})
    originalWeight: number;

    @Column()
    height : number;

    @ManyToOne(type => Group)
    @JoinColumn({ name: 'group_id' })
    group: Group


}
