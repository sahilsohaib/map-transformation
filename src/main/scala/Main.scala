object MapOperations {
  def main(args: Array[String]): Unit = {
    // Create a map of student names and their test scores
    val studentScores = Map(
      "Alice" -> List(90, 85, 92),
      "Bob" -> List(78, 89, 92),
      "Charlie" -> List(95, 91, 88)
    )

    // Use mapValues to calculate the average score for each student
    val averageScores = studentScores.mapValues(scores => scores.sum / scores.length)
    println(s"Average Scores: $averageScores")

    // Use flatMap to create a list of (student, score) pairs for each test
    val testScores = studentScores.flatMap { case (student, scores) =>
      scores.zipWithIndex.map { case (score, testNumber) =>
        s"$student - Test ${testNumber + 1}: $score"
      }
    }
    println("Test Scores:")
    testScores.foreach(println)

    // Use foldLeft to calculate the total score for all students
    val totalScore = studentScores.foldLeft(0) { case (total, (_, scores)) =>
      total + scores.sum
    }
    println(s"Total Test Scores: $totalScore")
  }
}
