/**
 * Copyright 2005-2010 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL 1.0 (the
 * "Licenses"). You can select the license that you prefer but you may not use
 * this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1.php
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1.php
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */

package org.restlet.ext.rdf.internal.ntriples;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.restlet.data.Reference;
import org.restlet.ext.rdf.Graph;
import org.restlet.ext.rdf.GraphHandler;
import org.restlet.ext.rdf.Link;
import org.restlet.ext.rdf.Literal;

/**
 * Handler of RDF content according to the N-Triples notation.
 * 
 * @author Thierry Boileau
 */
public class RdfNTriplesWriter extends GraphHandler {

    /** Buffered writer. */
    private BufferedWriter bw;

    /**
     * Constructor.
     * 
     * @param outputStream
     *            The output stream to write to.
     * @throws IOException
     */
    public RdfNTriplesWriter(OutputStream outputStream) throws IOException {
        super();
        this.bw = new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    @Override
    public void endGraph() throws IOException {
        this.bw.flush();
    }

    @Override
    public void link(Graph source, Reference typeRef, Literal target) {
        org.restlet.Context.getCurrentLogger().warning(
                "Subjects as Graph are not supported in N-Triples.");
    }

    @Override
    public void link(Graph source, Reference typeRef, Reference target) {
        org.restlet.Context.getCurrentLogger().warning(
                "Subjects as Graph are not supported in N-Triples.");
    }

    @Override
    public void link(Reference source, Reference typeRef, Literal target) {
        try {
            write(source);
            this.bw.write(" ");
            write(typeRef);
            this.bw.write(" ");
            write(target);
            this.bw.write(".\n");
        } catch (IOException e) {
            org.restlet.Context.getCurrentLogger().warning(
                    "Cannot write the representation of a statement due to: "
                            + e.getMessage());
        }
    }

    @Override
    public void link(Reference source, Reference typeRef, Reference target) {
        try {
            write(source);
            this.bw.write(" ");
            write(typeRef);
            this.bw.write(" ");
            write(target);
            this.bw.write(".\n");
        } catch (IOException e) {
            org.restlet.Context.getCurrentLogger().warning(
                    "Cannot write the representation of a statement due to: "
                            + e.getMessage());
        }
    }

    /**
     * Writes the representation of a literal.
     * 
     * @param literal
     *            The literal to write.
     * @throws IOException
     */
    private void write(Literal literal) throws IOException {
        // Write it as a string
        this.bw.write("\"");
        this.bw.write(literal.getValue());
        this.bw.write("\"");
    }

    /**
     * Writes the representation of a given reference.
     * 
     * @param reference
     *            The reference to write.
     * @throws IOException
     */
    private void write(Reference reference) throws IOException {
        String uri = reference.toString();
        if (Link.isBlankRef(reference)) {
            this.bw.write(uri);
        } else {
            this.bw.append("<");
            this.bw.append(uri);
            this.bw.append(">");
        }
    }

}
