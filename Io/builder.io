OperatorTable addAssignOperator(":", "atParseHash")

Builder := Object clone do(
    depth := 0

    atParseHash := method(
        key := call evalArgAt(0) asMutable removePrefix("\"") removeSuffix("\"")
        value := cal evalArgAt(1)
        " #{key}=\"#{value}\"" interpolate
    )

    curlyBrackets := method(
        call message arguments map(arg, self doMessage(arg)) join("")
    )

    forward := method(
        arguments := call message arguments
        name := call message name
        attributes := ""
        if(arguments size > 0 and arguments at(0) name == "curlyBrackets",
            attributes = doMessage(arguments removeFirst)
        )
        for(i, 1, depth, "  " print)
        writeln("<", name, ">")
        arguments foreach(arg,
                depth = depth + 1
                content := self doMessage(arg);
                if(content type == "Sequence", for(i, 1, depth, "  " print) writeln(content))
                depth = depth - 1
            )
        for(i, 1, depth, "  " print)
        writeln("</", call message name, ">")
    )


)


Builder html(
  head(
    title("Test webpage")
  ),
  body(
    h1("Welcome to my test webpage!"),
    div({"class": "content", "id": "main"},
      p("Lots of fun to be had!"),
      p("Don't forget to sign the guest book")
    )
  )
)