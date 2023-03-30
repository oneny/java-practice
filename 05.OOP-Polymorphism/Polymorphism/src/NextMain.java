public class NextMain {
  public static void main(String[] args) {
    Movie movie = Movie.getMovie("A", "Jaws");
    movie.watchMovie();

    Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
    jaws.watchMovie();

    // 컴파일러는 메서드 리턴 유형을 쓰지 않는다.
    Object comedy = Movie.getMovie("C", "Airplane");
    Movie comedyMovie = (Movie) comedy; // 캐스팅
    comedyMovie.watchMovie();

    var airplane = Movie.getMovie("C", "Airplane");
    airplane.watchMovie();

    var plane = new Comedy("Airplane");
    plane.watchComedy();

    Object unknownObject = Movie.getMovie("C", "Airplane");
    if (unknownObject.getClass().getSimpleName().equals("Comedy")) {
      Comedy c = (Comedy) unknownObject;
      c.watchComedy();
    } else if (unknownObject instanceof Adventure) {
      ((Adventure) unknownObject).watchAdventure();
    } else if (unknownObject instanceof ScienceFiction syfy) {
      // JDK 16에서 공식적으로 Java의 일부가 됨. 캐스팅 없이 바로 ScienceFiction 타입의 syfy 사용 가능
      syfy.watchScienceFiction();
    }
  }
}
