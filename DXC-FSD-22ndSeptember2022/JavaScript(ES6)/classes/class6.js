class Project {
  constructor() {
    console.log(new.target);
  }
}
var p = new Project();
