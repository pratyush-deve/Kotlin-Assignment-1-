data class student(val id: Int, val name: String, val age: Int, var avg:Int, var email:String)
fun add(students: MutableList<student>){
    println("Enter Student ID : ")
    val id=readLine()!!.toInt()
    println("Enter Name : ")
    val name=readLine()!!
    println("Enter Age : ")
    val age=readLine()!!.toInt()
    println("Enter Marks : ")
    println("Maths : ")
    val mk1=readLine()!!.toInt()
    println("Science : ")
    val mk2=readLine()!!.toInt()
    println("English : ")
    val mk3=readLine()!!.toInt()
    val avg=(mk1+mk2+mk3)/3
    println("Enter email : ")
    val email=readLine()!!

    val kid=student(id,name,age,avg,email)
    students.add(kid)
    println("Student has been successfully added.")
}

fun display(students: List<student>){
    if(students.isEmpty()) println("NO students found")
    else{
        students.map{"ID: ${it.id}, Name: ${it.name}, Age: ${it.age}, Email: ${it.email}"}.forEach{println(it)}
    }
}

fun sort(students: List<student>){
    var max=0
    for(i in students.indices){
        if (students[i].avg>max) {
            max = students[i].avg
        }
    }
    var found:String = " "
    for (i in students.indices){
        if(students[i].avg==max){
            found=students[i].name
        }
    }
    println("The topper is $found with the Average marks $max")
}

fun sort1(students: List<student>){
    if(students.isEmpty()) println("NO students found")
    else{
        val found=students.sortedBy { it.avg }.first()
        println("The topper is ${found.name} with the Average marks ${found.avg}")
    }
}

fun delete(students: MutableList<student>){
    println("Enter Student ID to delete : ")
    val id=readLine()!!.toInt()
    var i:Int=1
    for(i in students.indices){
        if(students[i].id == id){
            students.remove(students[i])
            break
        }
    }
    println("Student with ID: $id has been successfully deleted.")
}

fun update(students: MutableList<student>){
    println("Enter Student ID whose details you want to update : ")
    val id=readLine()!!.toInt()
    for(i in students.indices){
        if(students[i].id == id){
            println("Update Marks :- ")
            println("Maths : ")
            val mk1=readLine()!!.toInt()
            println("Science : ")
            val mk2=readLine()!!.toInt()
            println("English : ")
            val mk3=readLine()!!.toInt()
            val avg=(mk1+mk2+mk3)/3
            println("Update email :- ")
            val email=readLine()!!
            students[i].avg=avg
            students[i].email=email
            break
        }
    }
}

fun search(students: List<student>){
    println("Search by:\n1. Student ID\n2. Student Name ")
    when(readLine()!!.toInt()){
        1->{
            println("Enter Student ID : ")
            val ids=readLine()!!.toInt()
            if(students.isEmpty()) println("NO students found")
            else{
                val found=students.find { it.id == ids }
                if(found != null) println("Found Student ID : $found")
                else println("Student not found")
            }
        }
        2->{
            println("Enter Student Name : ")
            val names=readLine()!!
            if(students.isEmpty()) println("NO students found")
            else{
                val found1=students.find { it.name == names}
                if(found1 != null) println("Student with name ${found1.name} is found!!!")
                else println("Student $names not found!!!")
            }
        }
        else -> println("Invalid Input")
    }
}

fun main() {
val students = mutableListOf<student>()
var running = true
print("--- Student Menu ---\n")
while (running) {
    println("1. Add Student")
    println("2. View Students")
    println("3. Search Student")
    println("4. Find the topper")
    println("5. Delete Student")
    println("6. Update Student")
    println("7. Exit")
    print("Enter choice: ")
    when (readLine()?.toIntOrNull()) {
        1 -> {
            add(students)
        }

        2 -> {
            display(students)
        }

        3->{
            search(students)
        }

        4->{
            sort1(students)
        }

        5->{
            delete(students)
        }
        6->{
            update(students)
        }
        7->{
            println("Exiting...")
            running = false
        }
    }
}
}
