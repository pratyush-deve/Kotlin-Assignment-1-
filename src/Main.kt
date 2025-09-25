data class student(val id: Int, val name: String, val age: Int, val avg:Int, val email:String)
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
        students.forEach {println(it)}
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
                if(found1 != null) println("Student with name $found1 is found!!!")
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
    println("6. Exit")
    print("Enter choice: ")
    when (readLine()!!.toInt()) {
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
            sort(students)
        }

        5->{
            delete(students)
        }

        6->{
            println("Exiting...")
            running = false
        }
    }
}
}
