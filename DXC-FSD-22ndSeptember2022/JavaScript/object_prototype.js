// function Person(first, last, age, eye) {
//   this.firstName = first;
//   this.lastName = last;
//   this.age = age;
//   this.eyeColor = eye;
// }

// Person.prototype.nationality = "English";

// const myFather = new Person("John", "Doe", 50, "blue");

// console.log(myFather.nationality);

function Person(first, last, age, eye) {
  this.firstName = first;
  this.lastName = last;
  this.age = age;
  this.eyeColor = eye;
}

Person.prototype.name = function () {
  return this.firstName + " " + this.lastName;
};

const myFather = new Person("John", "Doe", 50, "blue");
console.log(myFather.name());
