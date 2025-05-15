terraform {
 required_providers {
   aws = {
     source  = "hashicorp/aws"
     version = "~> 3.0"
   }
 }
}

provider "aws" {
 region = var.region
}

variable "region" {
 default = "us-east-1"
 description = "AWS Region"
}

variable "ami" {
 default = "ami-084568db4383264d4"
 description = "Amazon Machine Image ID for Ubuntu Server 24.04"
}

variable "type" {
 default = "t2.micro"
 description = "Size of VM"
}

resource "aws_instance" "demo" {
 ami = var.ami
 instance_type = var.type

 tags = {
   Name = "Demo System"
 }
}