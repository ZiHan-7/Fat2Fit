import { Entity, PrimaryGeneratedColumn, Column, ManyToOne, JoinColumn, CreateDateColumn } from "typeorm";
import { User } from "./User";

@Entity({name: "records"})
export class Record {

    @PrimaryGeneratedColumn()
    id: number;

    @Column({name: "week_num"})
    weekNum : number;

    @Column()
    weight: number;

    @ManyToOne(type => User)
    @JoinColumn({ name: 'user_id' })
    user: User

    @Column({name: "water_intake"})
    waterIntake: number;

    @Column({name: "food_list"})
    foodList : string;

    @Column({name: "calory_intake"})
    caloryIntake: number;

    @Column({name: "exercise_list"})
    exerciseList: string;

    @Column({name: "calory_burn"})
    caloryBurn: number;

    @CreateDateColumn({name: "created_at"})
    createdAt;

    @CreateDateColumn({name: "updated_at"})
    updateAt;



   


}