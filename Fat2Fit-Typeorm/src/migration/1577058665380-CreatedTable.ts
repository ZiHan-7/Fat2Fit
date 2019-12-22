import {MigrationInterface, QueryRunner} from "typeorm";

export class CreatedTable1577058665380 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`CREATE TABLE "groups" ("id" int NOT NULL IDENTITY(1,1), "name" nvarchar(255) NOT NULL, CONSTRAINT "PK_659d1483316afb28afd3a90646e" PRIMARY KEY ("id"))`, undefined);
        await queryRunner.query(`CREATE TABLE "users" ("id" int NOT NULL IDENTITY(1,1), "name" nvarchar(255) NOT NULL, "age" int NOT NULL, "original_weight" int NOT NULL, "height" int NOT NULL, "group_id" int, CONSTRAINT "PK_a3ffb1c0c8416b9fc6f907b7433" PRIMARY KEY ("id"))`, undefined);
        await queryRunner.query(`CREATE TABLE "records" ("id" int NOT NULL IDENTITY(1,1), "week_num" int NOT NULL, "weight" int NOT NULL, "water_intake" int NOT NULL, "food_list" nvarchar(255) NOT NULL, "calory_intake" int NOT NULL, "exercise_list" nvarchar(255) NOT NULL, "calory_burn" int NOT NULL, "created_at" datetime2 NOT NULL CONSTRAINT "DF_4dd37de3cdfa0452570d440d0b3" DEFAULT getdate(), "updated_at" datetime2 NOT NULL CONSTRAINT "DF_2db16ee1792014024a280d10bc0" DEFAULT getdate(), "user_id" int, CONSTRAINT "PK_188149422ee2454660abf1d5ee5" PRIMARY KEY ("id"))`, undefined);
        await queryRunner.query(`ALTER TABLE "users" ADD CONSTRAINT "FK_b8d62b3714f81341caa13ab0ff0" FOREIGN KEY ("group_id") REFERENCES "groups"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`, undefined);
        await queryRunner.query(`ALTER TABLE "records" ADD CONSTRAINT "FK_27b2efc240866f140b8eb6ac554" FOREIGN KEY ("user_id") REFERENCES "users"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`, undefined);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "records" DROP CONSTRAINT "FK_27b2efc240866f140b8eb6ac554"`, undefined);
        await queryRunner.query(`ALTER TABLE "users" DROP CONSTRAINT "FK_b8d62b3714f81341caa13ab0ff0"`, undefined);
        await queryRunner.query(`DROP TABLE "records"`, undefined);
        await queryRunner.query(`DROP TABLE "users"`, undefined);
        await queryRunner.query(`DROP TABLE "groups"`, undefined);
    }

}
